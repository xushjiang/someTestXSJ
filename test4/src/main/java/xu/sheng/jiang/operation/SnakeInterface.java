package xu.sheng.jiang.operation;

import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface SnakeInterface {

	public Map<String, Object> getUsers(int user_id) throws Exception;

	public Map<String, Object> getUser() throws Exception;

}
