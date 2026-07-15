package net.likelion.bebc25.board03.post.service;

import net.likelion.bebc25.board03.post.dto.PostDto;
import net.likelion.bebc25.board03.post.repository.PostRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    // Repository 의존성 주입
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    // Repository에게 조회, 작성, 수정, 삭제 요청
    @Override
    public List<PostDto> getPosts() {
        return postRepository.findAll();
    }

    @Override
    public PostDto getPost(int id) {
        return postRepository.findById(id);
    }

    @Override
    public void writePost(PostDto post) {
        postRepository.save(post);
    }

    @Override
    public void editPost(PostDto post) {
        postRepository.update(post);
    }

    @Override
    public void removePost(int id) {
        postRepository.deleteById(id);
    }
}