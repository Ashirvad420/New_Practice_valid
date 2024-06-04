package com.NewPractice.service.Impl;

import com.NewPractice.entity.Post;
import com.NewPractice.payload.PostDto;
import com.NewPractice.repository.PostRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    // save the data in database
    public PostDto CreatePost(PostDto postDto) {


//        Post posts = new Post();
//        posts.setId(postDto.getId());
//        posts.setTitle(postDto.getTitle());
//        posts.setDescription(postDto.getDescription());
//        posts.setContent(posts.getDescription());

        Post posts = mapToEntity(postDto);

        Post saved = postRepository.save(posts);

//        PostDto dto = new PostDto();
//        dto.setId(saved.getId());
//        dto.setTitle(saved.getTitle());
//        dto.setDescription(saved.getDescription());
//        dto.setContent(saved.getContent());
        PostDto dto = mapToDto(saved);
        return dto;


    }

    Post mapToEntity(PostDto postDto) {
        Post posts = new Post();
        posts.setId(postDto.getId());
        posts.setTitle(postDto.getTitle());
        posts.setDescription(postDto.getDescription());
        posts.setContent(posts.getDescription());
        Post saved = postRepository.save(posts);
        return saved;
    }

    PostDto mapToDto(Post post) {
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());
        return dto;
    }

    // get data by id
    public Post getPostById(Long id) {
        Optional<Post> OpPost = postRepository.findById(id);
        if (OpPost.isPresent()) {
            Post post = OpPost.get();
            return post;
        }
        return null;
    }


    // get all data
    public List<PostDto> getAllPost() {
        List<Post> posts = postRepository.findAll();
        List<PostDto> dtos = posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
        return dtos;

    }

    // Pagination Concept.....  // http://localhost:8080/api/posts/PostPage?pageNo=0&pageSize=3
    // Pagination Concept.....  // http://localhost:8080/api/posts/PostPage?pageNo=0&pageSize=3&sortBy=title
    // Pagination Concept.....  // http://localhost:8080/api/posts/PostPage?pageNo=0&pageSize=3&sortDir=asc/desc


    public List<Post> getPostPage(int pageNo, int pageSize, String sortBy, String sortDir) {
       Sort sort = (sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()))?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo,pageSize, sort);
        Page<Post> page =postRepository.findAll(pageable);
        List<Post> posts = page.getContent();
        return posts;
    }


    // Delete By Id
    public Post getPostDeleteId(Long id) {
        Optional<Post> OpDt = postRepository.findById(id);
        if (OpDt.isPresent()) {
            postRepository.deleteById(id);
        }
        return null;
    }

    // Delete All Data
    public String getAllDataDelete() {
        postRepository.deleteAll();
        return "Deleted";
    }

    // Update the data using id
    public Post getUpdatePost(Long id, Post post) {
        Optional<Post> OpUpt = postRepository.findById(id);
        if (OpUpt.isPresent()) {
            Post pos = OpUpt.get();
            pos.setContent(post.getContent());
            postRepository.save(pos);

        }
        return null;
    }
}

// stream():- it takes the Object address(posts) and given to posts
// date:-2024-01-16 how to save data using map concept using stream api in getAll
// date:-2024-01-17 how to do pagination