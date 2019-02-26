package daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.staxrt.tutorial.model.User;
import com.staxrt.tutorial.repository.CustomTodoRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
final class TodoRepositoryImpl implements CustomTodoRepository {


	private static final String SEARCH_TODO_ENTRIES = "SELECT requestName from blog WHERE title=:title and content=:content";

	private final NamedParameterJdbcTemplate jdbcTemplate;

	@Autowired
	TodoRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Transactional(readOnly = true)
	@Override
	public List<User> findBySearchTerm(User searchTerm) {
		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("title", searchTerm.getTitle());
		queryParams.put("content", searchTerm.getContent());
		

		List<User> searchResults = jdbcTemplate.query(SEARCH_TODO_ENTRIES, queryParams,
				new BeanPropertyRowMapper<>(User.class));

		return searchResults;
	}
}