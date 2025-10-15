package com.crud.portifolio.controller;

import com.crud.portifolio.entity.Funcionarios;
import com.crud.portifolio.repository.FuncionariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FuncionariosController {
    @Autowired // Injeta automaticamente o repositório (injeção de dependência)
    private FuncionariosRepository funcionariosRepository;

    // ========================= GET (listar todos) =========================

    @GetMapping("/funcionarios")
    public List<Funcionarios> getAllFuncionarios() {
        // Busca e retorna todos os funcionários cadastrados no banco
        return funcionariosRepository.findAll();
    }

    // ========================= GET (buscar por ID) =========================

    @GetMapping("funcionarios/{id}")
    public Funcionarios getFuncionariosById(@PathVariable Long id) {
        // Busca um funcionário específico pelo ID
        // O método get() é usado porque findById() retorna um Optional
        return funcionariosRepository.findById(id).get();
    }

    // ==================== POST (criar novo funcionário) =====================

    @PostMapping("/funcionarios")
    public Funcionarios save(@RequestBody Funcionarios funcionarios) {
        // Salva um novo funcionário recebido no corpo da requisição (JSON)
        // O Spring converte automaticamente o JSON em um objeto Funcionarios
        return funcionariosRepository.save(funcionarios);
    }

    // ================= PUT (atualizar funcionário existente) ==============

    @PutMapping("/funcionarios/{id}")
    public Funcionarios updateFuncionarios(@PathVariable Long id, @RequestBody Funcionarios funcionariosAtualizado) {

        // O método findById() retorna um Optional. Usamos map() para processar
        // o funcionário se ele existir.
        return funcionariosRepository.findById(id).map(funcionarioExistente -> {

            // 1. Atualiza os campos do objeto existente com os novos dados
            funcionarioExistente.setName(funcionariosAtualizado.getName());
            funcionarioExistente.setIdade(funcionariosAtualizado.getIdade());
            funcionarioExistente.setCpf(funcionariosAtualizado.getCpf());
            funcionarioExistente.setCargo(funcionariosAtualizado.getCargo());

            // 2. Salva a atualização no banco de dados (o Spring Data JPA faz o UPDATE)
            return funcionariosRepository.save(funcionarioExistente);

        }).orElseGet(() -> {
            // Se o funcionário NÃO for encontrado (opcional, dependendo da sua regra de
            // negócio):

            // (a) Neste caso, criamos o funcionário se ele ainda não existir.
            // (b) Setamos o ID para garantir que o novo registro terá o ID da URL..
            funcionariosAtualizado.setId(id);
            return funcionariosRepository.save(funcionariosAtualizado);

        });
    }

    // ============== DELETE (excluir funcionário por ID) ======================

    @DeleteMapping("/funcionarios/{id}")
    public void deleteFuncionarios(@PathVariable Long id) {
        // Exclui o funcionário do banco de dados com base no ID informado
        funcionariosRepository.deleteById(id);
    }
}
