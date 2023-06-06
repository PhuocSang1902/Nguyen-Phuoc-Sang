package com.test_final_module_4.model;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "flag_remove = false")
@SQLDelete(sql="update question_content set flag_remove = true where id = ?")
public class QuestionContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Không được để trống")
    @Size(min = 5, max = 100, message = "Không đúng yêu cầu")
    private String title;
    @NotBlank(message = "Không được để trống")
    @Size(min = 10, max = 500, message = "Không đúng yêu cầu")
    private String content;
    private String answer;
    private String dateCreate;
    private String status = "Chưa phản hồi";
    @ManyToOne
    @NotNull(message = "Không được để trống")
    private QuestionType questionType;
    private boolean flagRemove = false;
}
