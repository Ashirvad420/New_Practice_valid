package com.NewPractice.service.Impl;

import com.NewPractice.entity.Comment;
import com.NewPractice.entity.Post;
import com.NewPractice.exception.ResourceNotFoundException;
import com.NewPractice.payload.CommentDto;
import com.NewPractice.repository.CommentRepository;
import com.NewPractice.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CommentService {

    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentService(CommentRepository commentRepository,PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public CommentDto createComment(CommentDto commentDto, long postId) {

      Post ps = postRepository.findById(postId).orElseThrow(
        ()->new ResourceNotFoundException("post not found"+postId)

        );
      Comment comment = new Comment();
      comment.setEmail(commentDto.getEmail());
      comment.setText(commentDto.getText());
      comment.setPost(ps);
      Comment saved= commentRepository.save(comment);


      CommentDto dto = new CommentDto();
      dto.setId(saved.getId());
      dto.setText(saved.getText());
      dto.setEmail(saved.getEmail());
      return dto;
    }

    public String deleteCommnet(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        if (comment.isPresent())
        {
           commentRepository.deleteById(id);
           return "delete";
        }
        return null;
    }

    // this is for comments
    public Comment getComments(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        if (comment.isPresent())
        {
            Comment comments = comment.get();
           return comments;
        }
        return null;
    }

    // this is for update
    public Comment updateComments(Long id, Comment comment) {
       Optional<Comment> comment1 = commentRepository.findById(id);
       if (comment1.isPresent())
       {
         Comment comme =  comment1.get();
         comme.setText(comment.getText());
         Comment saved = commentRepository.save(comme);
         return saved;
       }
       return null;
    }

    // this is for Pagination
    public List<Comment> getPagination(int pageNo, int pageSize,String sortBy, String sortDir) {
       Pageable pageable = PageRequest.of(pageNo,pageSize);
       Page<Comment> comment = commentRepository.findAll(pageable);
       List<Comment> comments = comment.getContent();
       Sort sort = (sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()))?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
       return comments;
    }
}
