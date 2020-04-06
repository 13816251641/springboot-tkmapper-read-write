package tkmapper;


import com.lujieni.tkmapper.TkmapperApplication;
import com.lujieni.tkmapper.dao.StudentDao;
import com.lujieni.tkmapper.domain.po.StudentPO;
import com.lujieni.tkmapper.service.IStudentService;
import com.lujieni.tkmapper.service.impl.StudentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TkmapperApplication.class)
public class StudentTableTest {
    @Autowired
    private StudentServiceImpl studentServiceImpl;

    @Autowired
    private StudentDao studentDao;

    @Test
    public void save(){
        studentServiceImpl.save(new StudentPO().setName("范玮琪").setAge(34));
    }

    @Test
    public void searchByCriteriaOne(){
        Example example = new Example(StudentPO.class);
        Example.Criteria criteria = example.createCriteria();
        /*andEqualTo中的property字段必须是实体类的成员属性!!!*/
        criteria.andEqualTo("age",34);
        List<StudentPO> studentPOS = studentServiceImpl.selectByExample(example);
        System.out.println(studentPOS);
    }

    @Test
    public void searchByCriteriaTwo(){
        Example example = new Example(StudentPO.class);
        Example.Criteria criteria = example.createCriteria();
        /*andCondition中的condition是db表中的字段*/
        criteria.andCondition("age=",34);
        List<StudentPO> studentPOS = studentServiceImpl.selectByExample(example);
        System.out.println(studentPOS);
    }


    @Test
    public void multiplexi(){
        Example example = new Example(StudentPO.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("age",23);
        List<StudentPO> studentPOS = studentServiceImpl.selectByExample(example);
        System.out.println(studentPOS);
        /*
         * 要想复用必须先清空example里的参数再重新创建criteria
         */
        example.clear();
        criteria = example.createCriteria();
        criteria.andEqualTo("name","范玮琪");
        studentPOS = studentServiceImpl.selectByExample(example);
        System.out.println(studentPOS);
    }


    @Test
    public void search2(){
        Example example = new Example(StudentPO.class);

        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",1);
        /*
            其实用example.or();也可以达到效果
         */
        Example.Criteria criteria2 =  example.createCriteria();
        criteria2.andEqualTo("name","a").andEqualTo("age",1);
        example.or(criteria2);
        studentDao.selectByExample(example);
    }



}
