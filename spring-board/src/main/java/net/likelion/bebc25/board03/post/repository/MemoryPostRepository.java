package net.likelion.bebc25.board03.post.repository;

import net.likelion.bebc25.board03.post.dto.PostDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// DB 대신 메모리(ArrayList)에 게시글을 저장하는 Repository 어노테이션
@Repository
public class MemoryPostRepository implements PostRepository {

    // 게시글들을 저장할 리스트
    private final List<PostDto> fakePosts;

    // 리스트 생성
    public MemoryPostRepository(){
        fakePosts = new ArrayList<PostDto>();

        // 테스트용 게시글
        PostDto post1 = new PostDto();
        post1.setId(1);
        post1.setTitle("1번 게시글");
        post1.setContent("1번 게시글 내용입니다.");
        post1.setAuthor("하루");
        post1.setSecret(true);
        post1.setCreatedAt(LocalDateTime.now());

        PostDto post2 = new PostDto();
        post2.setId(2);
        post2.setTitle("2번 게시글");
        post2.setContent("2번 게시글 내용입니다.");
        post2.setAuthor("나무");
        post2.setCreatedAt(LocalDateTime.now());

        // 리스트에 저장
        fakePosts.add(post1);
        fakePosts.add(post2);
    }

    // 모든 게시글 조회
    @Override
    public List<PostDto> findAll() {
        return fakePosts;
    }

    // id로 게시글 하나 찾기
    @Override
    public PostDto findById(int id) {
        for(PostDto org : fakePosts){
            if(org.getId() == id){
                return org;
            }
        }
        throw new IllegalArgumentException(id + "번 게시글은 존재하지 않습니다.");
    }

    // 게시글 저장
    @Override
    public void save(PostDto post) {
        PostDto lastPost = fakePosts.getLast();
        post.setId(lastPost.getId() + 1);
        post.setCreatedAt(LocalDateTime.now());
        fakePosts.add(post);
    }

    // 게시글 수정
    @Override
    public void update(PostDto post) {
        PostDto targetPost = null;
        for(PostDto org : fakePosts){
            if(org.getId() == post.getId()){
                targetPost = org;
                break;
            }
        }
        // 기존 객체 내용 변경
        targetPost.setTitle(post.getTitle());
        targetPost.setContent(post.getContent());
        targetPost.setAuthor(post.getAuthor());
    }

    // 게시글 삭제
    @Override
    public void deleteById(int id) {
        for(PostDto org : fakePosts){
            if(org.getId() == id){
                fakePosts.remove(org);
                break;
            }
        }
    }
}