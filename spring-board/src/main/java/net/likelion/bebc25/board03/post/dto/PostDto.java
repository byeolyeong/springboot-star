package net.likelion.bebc25.board03.post.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
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


}