package net.likelion.bebc25.board03.post.repository;

import net.likelion.bebc25.board03.post.dto.PostDto;

import java.util.List;

// 전체 게시글 조회 / 게시글 하나 조회 / 저장 / 게시글 수정 / 삭제
public interface PostRepository {
    List<PostDto> findAll();
    PostDto findById(int id);
    void save(PostDto post);
    void update(PostDto post);
    void deleteById(int id);
}