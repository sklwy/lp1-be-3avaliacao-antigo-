package com.project.lp1.service;

import com.project.lp1.exception.BadRequestException;
import com.project.lp1.model.Command;
import com.project.lp1.repository.CommandRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
public class CommandService {

    private final CommandRepository commandRepository;

    public CommandService(CommandRepository commandRepository) {
        this.commandRepository = commandRepository;
    }

    public Command insert(@Validated Command command) {
        return commandRepository.save(command);
    }

    public List<Command> findAll() {
        return commandRepository.findAll();
    }

    public Optional<Command> findById(Long commandId) {
        return Optional.ofNullable(commandRepository.findById(commandId)
                .orElseThrow(() -> new BadRequestException("Command Not Found!")));
    }
}
