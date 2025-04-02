package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;

// BEGIN
@RestController
public class PostsController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path = "/posts")
    @ResponseStatus(HttpStatus.OK)
    public List<Post> index() {
        return postRepository.findAll();
    }

    @GetMapping(path = "/posts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post show(@PathVariable long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
    }

    @PostMapping(path = "/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post post) {
        postRepository.save(post);
        return post;
    }

    @PutMapping(path = "/posts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post update(@PathVariable long id, @RequestBody Post post) {
        var postUpdate = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));

        postUpdate.setTitle(post.getTitle());
        postUpdate.setBody(post.getBody());

        return postUpdate;
    }

    @DeleteMapping(path = "/posts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable long id) {
        commentRepository.deleteByPostId(id);
        postRepository.deleteById(id);
    }

}
// END
