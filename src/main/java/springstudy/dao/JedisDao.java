package springstudy.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;
import springstudy.pojo.User;
import springstudy.util.RedisUtils;

@Repository
@SpringBootTest
public class JedisDao {
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private RedisUtils redisUtils;
	
    public  String redisOperate_jedis() {
//        Jedis jedis = new Jedis("192.168.2.120",6379);
    	Jedis jedis = new Jedis("127.0.0.1",6379);
//        System.out.println(jedis.ping());
//        jedis.set("name","liuwei");
//        System.out.println(jedis.get("name"));
//        jedis.set("yit1","111111111111111111111111111");
//        System.out.println(jedis.get("yit1"));
    	Transaction multi = jedis.multi();
    	try {
			multi.set("name1", "yit1");
			multi.set("name2", "liuwei");
			multi.set("myset","狂神易拓");
			multi.exec();
		} catch (Exception e) {
			// TODO Auto-generated catch block\
			multi.discard();
			e.printStackTrace();
		}
        return jedis.get("name")+jedis.get("yit1");


    }
    @Test
    public  String redisOperate_template() throws JsonProcessingException {
    	System.out.println("yi11");
    	User user = new User("狂神",33);
//    	String jsonuser = new ObjectMapper().writeValueAsString(user);
    	redisTemplate.opsForValue().set("user3",user );
    	System.out.println(redisTemplate.opsForValue().get("user"));
    	
    	
		return null;

  }
    @Test
    public  String redisOperate_redisutils() throws JsonProcessingException {
    	System.out.println("yi11");
    	User user = new User("狂神",33);
    	redisUtils.set("useryit1", user);
    	
    	
		return null;
		
    }
    @Test
    public  String redisOperate_redisutils_haskey() throws JsonProcessingException {
    	System.out.println("yi11");
    	User user = new User("狂神",33);
    	boolean exists = redisUtils.exists("useryit1");
    	
    	
		return exists+"";

    }
}
