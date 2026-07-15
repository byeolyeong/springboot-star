package net.likelion.bebc25.board03.post.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

// 게시글 하나를 저장할 객체
// 게시글 하나의 데이터를 저장하는 객체(DTO)
// Controller <-> Service <-> Repository 사이에서 데이터를 전달할 때 사용
public class PostDto {
    // 게시글 번호
    private int id;

    // 제목은 비어있으면 안되고 최대 100자 까지.
    @NotBlank(message = "제목은 필수 입력 항목입니다.")
    @Size(max = 100, message = "제목은 100자 이하로 입력해야 합니다.")
    private String title;

    // 내용은 필수 입력 사항
    @NotBlank(message = "내용은 필수 입력 항목입니다.")
    private String content;

    // 작성자도 필수 입력 사항, 작성자 이름은 2~ 10자 까지
    @NotBlank(message = "작성자는 필수 입력 항목입니다.")
    @Size(min = 2, max = 10, message = "작성자 이름은 2자 이상 10자 이하여야 합니다.")
    private String author;

    // 비밀글 여부
    private boolean secret;
    // 작성 시간
    private LocalDateTime createdAt;

    // boolean 타입 getter는 is--- 형태로 사용
    public boolean isSecret() {
        return secret;
    }

    public void setSecret(boolean secret) {
        this.secret = secret;
    }

    // 기본 생성자 생성
    // Spring이 객체를 생성할 때 사용
    public PostDto(){

    }

    // 글 작성 시 사용하는 생성자
    public PostDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // 게시글 전체 정보를 생성할 때 사용하는 생성자들
    public PostDto(int id, String title, String content, String author, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
    }

    // 아래는 각 필드의 getter / setter
    // 다른 클래스에서 값을 읽거나 수정하기 위해서 사용
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // 객체 내용을 출력할 때 사용
    @Override
    public String toString() {
        return "PostDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

}