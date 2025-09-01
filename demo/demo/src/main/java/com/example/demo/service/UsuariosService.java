package com.example.demo.service;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.UsuariosDto;
import com.example.demo.model.Estabelecimentos;
import com.example.demo.model.Usuarios;
import com.example.demo.model.enumeration.Funcoes;
import com.example.demo.repository.EstabelecimentosRepository;
import com.example.demo.repository.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Autowired
    private EstabelecimentosRepository estabelecimentosRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // Listar todos
    public List<Usuarios> listAllUsuarios() {
        return usuariosRepository.findAll();
    }

    // Buscar por ID (opcional, mas útil)
    public Optional<Usuarios> getUsuarioById(Long id) {
        return usuariosRepository.findById(id);
    }

    public void cadastrarUsuario(LocalDateTime dataNascimento, String cpf, Long estabelecimentoId,
                             String linkImg, String nome, String senha, String sobrenome, String status, String email, List<Funcoes> funcoes) {

        Estabelecimentos e = estabelecimentosRepository.getReferenceById(estabelecimentoId);

        String senhaCriptografada = passwordEncoder.encode(senha);

        Usuarios usuario = new Usuarios();
        usuario.setCpf(cpf);
        usuario.setStatusUsuario(status);
        usuario.setNome(nome);
        usuario.setSobrenome(sobrenome);
        usuario.setSenha(senhaCriptografada);
        usuario.setDataNascimento(dataNascimento);
        usuario.setLinkImagem(linkImg);
        usuario.setEmail(email);
        usuario.setServicos(new HashSet<>());
        usuario.setFuncoes(funcoes);

        e.getUsuarios().add(usuario);

        usuario.setEstabelecimento(e);

        usuariosRepository.save(usuario);
        estabelecimentosRepository.save(e);
    }

    public void cadastrarUsuario(UsuariosDto dto) {

        Estabelecimentos e = estabelecimentosRepository.getReferenceById(dto.getEstabelecimento().getId());

        String senhaCriptografada = passwordEncoder.encode(dto.getSenha());

        Usuarios usuario = new Usuarios();
        usuario.setCpf(dto.getCpf());
        usuario.setStatusUsuario(dto.getStatusUsuario());
        usuario.setNome(dto.getNome());
        usuario.setSobrenome(dto.getSobrenome());
        usuario.setSenha(senhaCriptografada);
        usuario.setDataNascimento(dto.getDataNascimento());
        usuario.setLinkImagem(dto.getLinkImagem());
        usuario.setEmail(dto.getEmail());
        usuario.setServicos(new HashSet<>());
        usuario.setFuncoes(dto.getFuncoes());

        e.getUsuarios().add(usuario);

        usuario.setEstabelecimento(e);

        usuariosRepository.save(usuario);
        estabelecimentosRepository.save(e);
    }


    public String validarLogin(LoginDto loginDto) {
        // Busca o usuário pelo email
        Usuarios usuario = usuariosRepository.findByEmail(loginDto.getEmail());

        if (usuario == null) {
            return null; // Usuário não encontrado
        }

        boolean senhaValida = passwordEncoder.matches(loginDto.getSenha(), usuario.getSenha());

        if (!senhaValida) {
            return null; // Senha inválida
        }

        // Gera o token JWT
        String token = JwtService.gerarToken(usuario.getEmail());
        return token;
    }

    public void atualizarUsuario(UsuariosDto dto){

        Usuarios u = usuariosRepository.getReferenceById(dto.getId());

        u.setDataNascimento(dto.getDataNascimento());
        u.setFuncoes(dto.getFuncoes());
        u.setEmail(dto.getEmail());
        u.setSobrenome(dto.getSobrenome());
        u.setCpf(dto.getCpf());
        u.setLinkImagem(dto.getLinkImagem());
        u.setNome(dto.getNome());
        u.setSenha(dto.getSenha());
        u.setStatusUsuario(dto.getStatusUsuario());

        usuariosRepository.save(u);
    }

    public void deletarUsuario(Long id){
        Usuarios u = usuariosRepository.getReferenceById(id);
        usuariosRepository.delete(u);
    }

}
