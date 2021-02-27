package springstudy.pojo;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


//通过lombok简化代码的编写
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable{
	public String name;
	public int age;

   
}