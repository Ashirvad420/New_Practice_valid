package com.NewPractice.controller;

import com.NewPractice.entity.Comment;
import com.NewPractice.entity.Post;
import com.NewPractice.payload.CommentDto;
import com.NewPractice.service.Impl.CommentService;
import com.NewPractice.service.Impl.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/saveCom")
    public ResponseEntity<CommentDto> createComment(
            @RequestBody CommentDto commentDto,
            @RequestParam long postId
    ) {
        CommentDto comment = commentService.createComment(commentDto, postId);
        if (comment != null) {
            return new ResponseEntity<>(comment, HttpStatus.OK);
        }
        return null;
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getComments(@PathVariable Long id) {
        Comment newCom = commentService.getComments(id);
        if (newCom != null) {
            return new ResponseEntity<>(newCom, HttpStatus.OK);
        }
        return new ResponseEntity<>("Id is Not Found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/pagination")
    public ResponseEntity<?> getPagination(

            @RequestParam(name = "pageNo", required = false, defaultValue = "0") int pageNo,
            @RequestParam(name = "pageSize", required = false, defaultValue = "3") int pageSize,
            @RequestParam(name = "sortBy", required = false, defaultValue = "id") String sortBy,
            @RequestParam(name = "sortDir",required = false, defaultValue = "id") String sortDir
    )
    {


     List<Comment> comments =commentService.getPagination(pageNo,pageSize,sortBy,sortDir);
    return new ResponseEntity<>(comments,HttpStatus.OK);
   }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Long id)
    {
        String comment = commentService.deleteCommnet(id);
        return new ResponseEntity<>(comment,HttpStatus.OK);
    }


    @PutMapping("/Update/{id}")
    public ResponseEntity<?> updateComments(@PathVariable Long id, @RequestBody Comment comment)
    {
        Comment com = commentService.updateComments(id,comment);
        if (com!=null)
        {
            return new ResponseEntity<>(com,HttpStatus.OK);
        }
        return new ResponseEntity<>("id is not found in this location",HttpStatus.NOT_FOUND);
    }
}
