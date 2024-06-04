package com.NewPractice.controller;

import com.NewPractice.entity.Post;
import com.NewPractice.payload.PostDto;
import com.NewPractice.service.Impl.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {


    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    // save the data in database
    @PostMapping("/save")
    public ResponseEntity<?> CreatePost(@RequestBody PostDto postDto)
    {
        PostDto post1 = postService.CreatePost(postDto);
        return new ResponseEntity<>(post1, HttpStatus.CREATED);
    }

    // get data by id
    @GetMapping("Post/{id}")
    public ResponseEntity<?> getPostById(@PathVariable Long id)
    {
        Post ps= postService.getPostById(id);
        if (ps!=null)
        {
            return new ResponseEntity<>(ps,HttpStatus.OK);
        }
        return new ResponseEntity<>("Record not found for this Id",HttpStatus.NOT_FOUND);
    }

    // get all data
    @GetMapping("new/all")

    public List<PostDto> getAllPost()
    {
        List<PostDto> ps = postService.getAllPost();
        return ps;
    }


    // Pagination Concept.....  // http://localhsot:8080/api/posts?pageNo=0&pageSize=3
    // Pagination Concept.....  // http://localhsot:8080/api/posts?pageNo=0&pageSize=3&sortBy=title
    // Pagination Concept.....  // http://localhsot:8080/api/posts?pageNo=0&pageSize=3&sortBy=title&sortDir=asc/desc

    @GetMapping("/PostPage")
    public List<Post> getPostPage
    (
        @RequestParam(name = "pageNo", required = false, defaultValue = "0") int pageNo,
        @RequestParam(name = "pageSize", required = false,defaultValue = "3") int pageSize,
        @RequestParam(name = "sortBy",required = false, defaultValue = "id") String sortBy,
        @RequestParam(name = "sortDir", required = false, defaultValue = "id") String sortDir
    )
    {
        List<Post> posts = postService.getPostPage(pageNo, pageSize,sortBy,sortDir);
        return posts;
    }

    // Delete By Id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> getPostDeleteId(@PathVariable Long id)
    {
        Post post = postService.getPostDeleteId(id);
        if (post!=null)
        {
            return new ResponseEntity<>(post,HttpStatus.OK);
        }
        return new ResponseEntity<>("data is Deleted for this id",HttpStatus.NOT_FOUND);
    }

    // Delete All Data
    @DeleteMapping("/all")
    public String getAllDataDelete()
    {
        String  str = postService.getAllDataDelete();
        return str;
    }

    // Update the data using id
    @PutMapping("upt/{id}")
    public ResponseEntity<?> getUpdatePost(@PathVariable Long id, @RequestBody Post post)
    {
        Post upt = postService.getUpdatePost(id,post);
        if (upt!=null)
        {
            return new ResponseEntity<>(upt,HttpStatus.OK);
        }
        return new ResponseEntity<>("Not found Id for update",HttpStatus.NOT_FOUND);
    }
}
