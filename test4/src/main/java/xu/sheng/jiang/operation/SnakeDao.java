package xu.sheng.jiang.operation;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

//@Repository(value = "snakeDao")
@Transactional(rollbackFor = Exception.class)
public class SnakeDao implements SnakeInterface {

//	springJDBC
	@Autowired
	JdbcTemplate jdbcTemplate;

	// Mybatis

	@Override
	public Map<String, Object> getUser() throws Exception {

//		SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT * FROM dihou_user WHERE user_id=246 ");
//		if (sqlRowSet == null || sqlRowSet.getMetaData().getColumnCount() <= 0) {
//			System.out.println("sqlRowSet is null!");
//		} else {
//			System.out.println(sqlRowSet.getObject(1));
//			while (sqlRowSet.next()) {
//				for (int i = 1; i <= sqlRowSet.getMetaData().getColumnCount(); i++) {
//					Object value = sqlRowSet.getObject(i);
//					System.out.println(value);
//				}
//			}
//		}

		Map<String, Object> map = jdbcTemplate.queryForMap("SELECT * FROM dihou_user WHERE user_id=246 ");
		System.out.println(map.get("user_id"));

//		List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT * FROM dihou_user WHERE user_id=246 ");
//		System.out.println(list.get(0).get("user_id"));

//		jdbcTemplate.update("DELETE FROM dihou_user WHERE user_id=186");
		return null;
	}

	@Override
	public Map<String, Object> getUsers(int user_id) throws Exception {

		return null;
	}

}
