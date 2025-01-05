package com.example.demo.application.tasks;

import com.example.demo.application.tasks.exceptions.TaskNaoEncontradaException;
import com.example.demo.domain.tasks.PriorityTask;
import com.example.demo.domain.tasks.Tasks;
import com.example.demo.domain.tasks.TasksRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TasksRepository tasksRepository;

    public TaskService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    // Retorna as tasks com paginação, o offset é a página
    public List<Tasks> findAllTasks(int offset) {
        return tasksRepository.findAllTasks(offset);
    }

    // Retorna o n° total de tasks, independente do status
    public int totalTasks() {
        return tasksRepository.totalTasks();
    }

    // Retorna as tasks já marcadas como COMPLETED, as que já foram completadas
    public int countAllTasks() {
        return tasksRepository.countAllTasks();
    }

    // Retorna um valor com duas casas de precisão representando a média entre as prioridades das tasks pendentes
    // Esse valor posteriormente é convertido novamente em um ENUM, por isso o retorno é um PriorityTask
    public PriorityTask mediaPriority() {
        return tasksRepository.mediaPriority();
    }

    // Busca uma task pelo id
    public Tasks findById(int id_task) throws RuntimeException {
        Tasks tasksDomain = tasksRepository.findById(id_task);
        // validação se a task existe para o id informado
        if (tasksDomain == null)
            // Exception personalizada para caso de not found
            throw new TaskNaoEncontradaException();
        return tasksDomain;
    }

    // Inserção da task
    public Tasks insertTask(TaskCreateDTO taskCreate) {
        // Converte o dto em um objeto do domínio
        Tasks tasksDomain =  taskCreate.toTasks();
        // Chama o método de inserção
        tasksRepository.insertTask(tasksDomain);
        // Como o banco faz o auto incremente do id, não sabemos qual é, mas como já inserimos no banco,
        // podemos calcular a quantidade de tasks e setar como id para devolver ao cliente o objeto completo
        tasksDomain.setId_task(totalTasks());
        return tasksDomain;
    }

    // Atualização da task
    public Tasks updateTask(TaskUpdateDTO taskUpdate, int id_task) {
        // Validação se a task existe
        if (tasksRepository.findById(id_task) == null)
            // Exception personalizada em caso de not found
            throw new TaskNaoEncontradaException();
        // Converte o dto em um objeto de domínio
        Tasks tasksDomain =  taskUpdate.toTasks(id_task);
        // Chama o método para a atualização
        tasksRepository.updateTask(tasksDomain);
        return findById(id_task);
    }

    public void deleteTask(int id_task) {
        // Validação se a task existe para o id
        if (tasksRepository.findById(id_task) == null)
            // Exception personalizada em caso de not found
            throw new TaskNaoEncontradaException();
        tasksRepository.deleteTask(id_task);
    }
}
