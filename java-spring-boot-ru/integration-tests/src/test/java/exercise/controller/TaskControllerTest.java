package exercise.controller;

import org.junit.jupiter.api.Test;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;
import org.instancio.Instancio;
import org.instancio.Select;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.datafaker.Faker;
import exercise.repository.TaskRepository;
import exercise.model.Task;

// BEGIN
@SpringBootTest
@AutoConfigureMockMvc
// END
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Faker faker;

    @Autowired
    private ObjectMapper om;

    @Autowired
    private TaskRepository taskRepository;


    @Test
    public void testWelcomePage() throws Exception {
        var result = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThat(body).contains("Welcome to Spring!");
    }

    @Test
    public void testIndex() throws Exception {
        var result = mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThatJson(body).isArray();
    }

    public Task createTask() {
        var task = Instancio.of(Task.class)
                .ignore(Select.field(Task::getId))
                .create();
        taskRepository.save(task);

        return task;
    }


    // BEGIN
    @Test
    public void testShow() throws Exception {
        var task = createTask();

        var req = get("/tasks/" + task.getId());

        var result = mockMvc.perform(req)
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThatJson(body).and(a -> a.node("title").isEqualTo(task.getTitle()));

    }

    @Test
    public void testCreate() throws Exception {
        var task = createTask();

        var req = post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(task));

        var result = mockMvc.perform(req)
                .andExpect(status().isCreated())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThatJson(body).and(a -> a.node("title").isEqualTo(task.getTitle()));
    }

    @Test
    public void testUpdate() throws Exception {
        var task = createTask();

        var data = new HashMap<>();
        data.put("title", "CHUPAPI");

        var req = put("/tasks/" + task.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(data));

        var result = mockMvc.perform(req)
                .andExpect(status().isOk())
                .andReturn();

        var taskUpdated = taskRepository.findById(task.getId()).get();
        assertThat(taskUpdated.getTitle()).isEqualTo(data.get("title"));
    }

    @Test
    public void testDelete() throws Exception {
        var task = createTask();

        var req = delete("/tasks/" + task.getId());

        var result = mockMvc.perform(req)
                .andExpect(status().isOk());
    }
    // END
}
