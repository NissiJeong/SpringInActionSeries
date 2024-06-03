package nissy.spring.tacos.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import nissy.spring.tacos.Ingredient;

@Repository //@Repository 어노테이션은 스프링이 정의하는 스테레오타입 어노테이션 중 하나, @Component에서 특화된 데이터 액세스 관련 어노테이션.
public class JdbcIngredientRepository implements IngredientRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        /*
         * jdbc.query의 인자 
         * 첫 번째 인자: 쿼리를 수행하는 SQL
         * 두 번째 인자: 스프링의 RowMapper 인터페이스를 우리가 구현한 mapRowToIngredient 메서드. 이 메서드는 Result set의 행 개수만큼 호출되며, 
         * Result set의 모든 행을 각각 객체(Ingredient)로 생성하고 List에 저장한 후 반환.
         */
        return jdbc.query("select id, name, type from Ingredient", this::mapRowToIngredient);
    }

    @Override
    public Ingredient findById(String id) {
        return jdbc.queryForObject("select id, name, type from Ingredient where id=?", this::mapRowToIngredient, id);
    }

    /*
     * 데이터 추가하기
     */
    @Override
    public Ingredient save(Ingredient ingredient) {
        jdbc.update("insert into Ingredient (id, name, type) values(?, ?, ?)", 
                        ingredient.getId(), 
                        ingredient.getName(), 
                        ingredient.getType().toString());
        return ingredient;
    }

    // 스프링의 RowMapper 인터페이스를 직접 구현한 메소드
    private Ingredient mapRowToIngredient(ResultSet rs, int rowNum) throws SQLException {
        return new Ingredient(rs.getString("id"), rs.getString("name"), Ingredient.Type.valueOf(rs.getString("type")));
    }
}
