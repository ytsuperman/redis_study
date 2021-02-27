package springstudy.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import springstudy.dao.JedisDao;

import springstudy.pojo.User;
import springstudy.util.RedisUtils;



/**
 * 测试controller
 *
 * @author liucheng
 **/
@RestController
public class Controller {
    
    @Autowired
    public JedisDao jedisDao;
    @Autowired
    public RedisUtils redisUtils;
    @RequestMapping("/index")
    public String method() throws JsonProcessingException {
    	System.out.println("1");
    	System.out.println("1");
    	System.out.println("1");
//        String res = jedisDao.redisOperate_jedis();
        jedisDao.redisOperate_template();
        jedisDao.redisOperate_redisutils();
        String redisOperate_redisutils_haskey = jedisDao.redisOperate_redisutils_haskey();
        
        String res = "nnnnnnnnnnnn";
       
		return res+redisOperate_redisutils_haskey;
      

    }

}
