package com.project.lp1.controller;

import com.project.lp1.model.Command;
import com.project.lp1.service.CommandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequestMapping("/api/command")
@RestController
public class CommandController {

    private final CommandService commandService;

    public CommandController(CommandService commandService) {
        this.commandService = commandService;
    }

    @PostMapping
    public ResponseEntity<Command> insert(@RequestBody Command command) {
        return new ResponseEntity<>(commandService.insert(command), HttpStatus.CREATED);
    }

    @GetMapping(path = "/list")
    public ResponseEntity<List<Command>> list() {
        return ResponseEntity.ok(commandService.findAll());
    }

    @GetMapping(path = "/{commandId}")
    public ResponseEntity<Optional<Command>> findById(@PathVariable Long commandId) {
        return ResponseEntity.ok(commandService.findById(commandId));
    }
}
