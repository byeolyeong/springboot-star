package net.likelion.bebc25.board03.post.repository;

import net.likelion.bebc25.board03.post.dto.PostDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

// DB와 통신하는 Repository
@Repository
public class JdbcTemplatePostRepository implements PostRepository{

    // SQL을 실행해주는 객체(Spring이 자동 생성해서 주입해줌)
    private final JdbcTemplate jdbcTemplate;

    // 생성자 주입
    public JdbcTemplatePostRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    // RowMapper
    // DB에서 조회한 한 행을 PostDto 객체로 변환을 하고, query(), queryForObject() 에서 자동으로 사용
    private final RowMapper<PostDto> postRowMapper = (rs, rowNum) -> {
//        return new PostDto(rs.getInt("id")
//                , rs.getString("title")
//                , rs.getString("content")
//                , rs.getString("author")
//                , rs.getBoolean("secret")
//                , rs.getObject("created_At", LocalDateTime.class));

        // builder 패턴을 이용해서 PostDto 객체를 생성( 컬럼 > 변수 )
        return PostDto.builder()
                .id(rs.getInt("id"))
                .title(rs.getString("title"))
                .author(rs.getString("author"))
                .createdAt(rs.getObject("created_At", LocalDateTime.class))
                .content(rs.getString("content"))
                .secret(rs.getBoolean("secret")).build();
    };

    @Override
    public List<PostDto> findAll() {
        // Select 결과의 각 행을 RowMapper가 PostDto로 변환
        return jdbcTemplate.query("SELECT * FROM post2", postRowMapper);
    }

    @Override
    public PostDto findById(int id) {
        // ?에는 id가 들어감
        // queryForObject() 는 하나의 결과를 볼 때 사용
        return jdbcTemplate.queryForObject("SELECT * FROM post2 WHERE id = ?", postRowMapper, id);
    }

    @Override
    public void save(PostDto post) {
        // Insert SQL 실행
        jdbcTemplate.update("INSERT INTO post2 (title, author, content) VALUES (?, ?, ?)"
                , post.getTitle()
                , post.getAuthor()
                , post.getContent());
    }

    @Override
    public void update(PostDto post) {
        // Update SQL 실행
        jdbcTemplate.update("UPDATE post2 SET title = ?, author = ?, content = ? WHERE id = ?"
                , post.getTitle()
                , post.getAuthor()
                , post.getContent()
                , post.getId());
    }

    @Override
    public void deleteById(int id) {
        // id에 해당하는 게시글 삭제
        jdbcTemplate.update("DELETE FROM post2 WHERE id=?", id);
    }
}
