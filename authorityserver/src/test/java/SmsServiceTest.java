import com.wen.AuthorityApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wenfeng on 2017/7/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = AuthorityApplication.class)
public class SmsServiceTest {
    @Autowired
    private BCryptPasswordEncoder  bCryptPasswordEncoder;


    @Test
    public void testBCryptPasswordEncoder(){
        System.out.println(bCryptPasswordEncoder.encode("123456"));
    }

}
