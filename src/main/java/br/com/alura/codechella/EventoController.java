package br.com.alura.codechella;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService servico;

    @GetMapping //(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<EventoDto> obterTodos(){
        return servico.obterTodos();
    }

    @GetMapping("/{id}") //(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<EventoDto> obterPorId(@PathVariable Long id){
        return servico.obterPorId(id);
    }



}
