package com.example.todoapp.controller;

import com.example.todoapp.controller.request.ToDoCreateRequest;
import com.example.todoapp.controller.response.ToDoCreateResponse;
import com.example.todoapp.model.ToDo;
import com.example.todoapp.repo.ToDo.ToDoEntity;
import com.example.todoapp.service.todo.ToDoService;
import com.example.todoapp.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;


@Controller
@RequiredArgsConstructor

public class ToDoController {

    private final ToDoService toDoService;
    private final UserService userService;

    @GetMapping("/todos")
    public String todos(Model model) {
        model.addAttribute("todos", toDoService.findAll()
                .stream()
                .filter(toDo -> toDo.getMemberId().equals(getValidUserName()))
                .collect(Collectors.toList()));
        return "todos";
    }

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("todos", toDoService.findAll()
                .stream()
                .filter(toDo -> toDo.getMemberId().equals(getValidUserName()))
                .collect(Collectors.toList()));
        return "index";
    }


    @PostMapping("/todoNew")
    public String add(@ModelAttribute @Valid ToDoCreateRequest toDoCreateRequest) {
        toDoCreateRequest.setMemberId(getValidUserName());
        ToDo todo = toDoCreateRequest.convertToToDo();
        Long id = toDoService.save(todo);
        return "redirect:/todos";
    }

    public Long getValidUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return userService.retrieveByMail(authentication.getName());
        }
        else
        {
            return 0L;
        }
    }

    @PostMapping("/todoEditSave")
    public String todoEditSave( @ModelAttribute("todo") ToDoEntity toDoEntity) {
        toDoEntity.setMemberId(getValidUserName());
        toDoService.update(toDoEntity);
        return "redirect:/todos";
    }

    @RequestMapping("/showTodoEdit/{id}")
    public String showFormForTodoUpdate(@PathVariable Long id ,Model theModel) {
        ToDoEntity todo = toDoService.retrieve(id).convertToTODOEntity();
        theModel.addAttribute("todo", todo);
        return "todoedit";
    }

    @PostMapping("/todoDelete/{id}")
    public String delete(@PathVariable Long id) {
        toDoService.delete(id);
        return "redirect:/todos";
    }

    @PostMapping("/todoUpdate/{id}")
    public String update(@PathVariable Long id, Model model) {
        ToDoEntity toDoEntity = toDoService.retrieve(id).convertToTODOEntity();
        if ("yes".equals(toDoEntity.getCompleted())) {
            toDoEntity.setCompleted("no");
        } else {
            toDoEntity.setCompleted("yes");
        }
        toDoService.update(toDoEntity);
        model.addAttribute("todos", toDoService.findAll());
        return "redirect:/todos";
    }
}
