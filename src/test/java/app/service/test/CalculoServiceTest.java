package app.service.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import app.service.CalculoService;

@SpringBootTest
public class CalculoServiceTest {
	
	@Autowired
	CalculoService calculoService;

	@Test
	@DisplayName("Cena 01 - Testando o método somar com valores válidos")
	void cenario01() {
		List<Integer> lista = new ArrayList<>();
		lista.add(3);
		lista.add(5);
		lista.add(2);
		
		int resultadoEsperado = 10;
		int resultadoObtido = this.calculoService.soma(lista);
		
		assertEquals(resultadoEsperado, resultadoObtido);
	}
	

	@Test
	@DisplayName("Cena 02 - Testando o método somar com valores inválidos")
	void cenario02() {
		List<Integer> lista = new ArrayList<>();
		lista.add(3);
		lista.add(null);
		lista.add(2);
				
		assertThrows(Exception.class,() -> {
			this.calculoService.soma(lista);
		});
		
		
	}
	
	
	@Test
	@DisplayName("Cena 03 - Testar mediana com número par de elementos")
	void cenario03() {
		List<Integer> lista = new ArrayList<>();
		lista.add(3);
		lista.add(2);
		lista.add(3);
		lista.add(4);
		
		assertEquals(3, this.calculoService.mediana(lista));
	}
	
	@Test
	@DisplayName("Cena 04 - Testar mediana com número ímpar de elementos")
	void cenario04() {
		List<Integer> lista = new ArrayList<>();
		lista.add(3);
		lista.add(2);
		lista.add(1);
		lista.add(9);
		lista.add(4);
		
		assertEquals(3, this.calculoService.mediana(lista));
	}
	
	
	@Test
	@DisplayName("Cena 05 - Testar mediana com número ímpar de elementos")
	void cenario05() {
		List<Integer> lista = new ArrayList<>();
		lista.add(8);
		lista.add(2);
		lista.add(1);
		lista.add(9);
		lista.add(39);
		lista.add(339);
		lista.add(4);
		
		assertEquals(8, this.calculoService.mediana(lista));
	}
	
	 // ---------- Maior Número ----------
    @Test
    @DisplayName("Cenário 01 - Maior número com apenas um elemento")
    void maiorNumeroUnico() {
        List<Integer> lista = new ArrayList<>();
        lista.add(42);
        assertThat(calculoService.maiornumerolista(lista)).isEqualTo(42);
    }

    @Test
    @DisplayName("Cenário 02 - Maior número com valores repetidos")
    void maiorNumeroRepetidos() {
        List<Integer> lista = new ArrayList<>();
        lista.add(10);
        lista.add(10);
        lista.add(10);
        assertEquals(10, calculoService.maiornumerolista(lista));
    }

    @Test
    @DisplayName("Cenário 03 - Lista nula deve lançar exceção")
    void maiorNumeroNulo() {
        assertThrows(IllegalArgumentException.class, () -> calculoService.maiornumerolista(null));
    }

    // ---------- Menor Número ----------
    @Test
    @DisplayName("Cenário 04 - Menor número com negativos")
    void menorNumeroNegativos() {
        List<Integer> lista = new ArrayList<>();
        lista.add(-10);
        lista.add(-20);
        lista.add(-5);
        assertTrue(calculoService.menornumerolista(lista) < 0);
    }

    @Test
    @DisplayName("Cenário 05 - Menor número é zero")
    void menorNumeroZero() {
        List<Integer> lista = new ArrayList<>();
        lista.add(5);
        lista.add(0);
        lista.add(10);
        assertEquals(0, calculoService.menornumerolista(lista));
    }

    @Test
    @DisplayName("Cenário 06 - Lista vazia deve lançar exceção")
    void menorNumeroVazia() {
        assertThrows(IllegalArgumentException.class, () -> calculoService.menornumerolista(new ArrayList<>()));
    }

    // ---------- Contagem de números ----------
    @Test
    @DisplayName("Cenário 07 - Lista com vários elementos")
    void contarNumerosLista() {
        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);
        assertThat(calculoService.numeroslista(lista)).isGreaterThan(4).isEqualTo(5);
    }

    @Test
    @DisplayName("Cenário 09 - Lista nula lança exceção")
    void contarNumerosNula() {
        assertThrows(IllegalArgumentException.class, () -> calculoService.numeroslista(null));
    }

    // ---------- Moda ----------
    @Test
    @DisplayName("Cenário 10 - Moda com valor mais frequente")
    void modaSimples() {
        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(2);
        lista.add(3);
        lista.add(2);
        assertEquals(2, calculoService.modaLista(lista));
    }

    @Test
    @DisplayName("Cenário 11 - Moda com empate")
    void modaEmpate() {
        List<Integer> lista = new ArrayList<>();
        lista.add(4);
        lista.add(4);
        lista.add(5);
        lista.add(5);
        int resultado = calculoService.modaLista(lista);
        assertThat(List.of(4, 5)).contains(resultado);
    }

    @Test
    @DisplayName("Cenário 12 - Lista vazia para moda deve lançar exceção")
    void modaVazia() {
        assertThrows(IllegalArgumentException.class, () -> calculoService.modaLista(new ArrayList<>()));
    }

    // ---------- Ímpares ----------
    @Test
    @DisplayName("Cenário 13 - Nenhum número ímpar")
    void imparesNenhum() {
        List<Integer> lista = new ArrayList<>();
        lista.add(2);
        lista.add(4);
        lista.add(6);
        assertThat(calculoService.quantidadeImpares(lista)).isZero();
    }

    @Test
    @DisplayName("Cenário 14 - Lista com ímpares negativos")
    void imparesNegativos() {
        List<Integer> lista = new ArrayList<>();
        lista.add(-1);
        lista.add(-3);
        lista.add(-5);
        lista.add(2);
        assertEquals(3, calculoService.quantidadeImpares(lista));
    }

    @Test
    @DisplayName("Cenário 15 - Todos ímpares")
    void imparesTodos() {
        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(3);
        lista.add(5);
        lista.add(7);
        int resultado = calculoService.quantidadeImpares(lista);
        assertTrue(resultado == lista.size());
    }

    // ---------- Soma de Pares ----------
    @Test
    @DisplayName("Cenário 16 - Lista com mistura de pares e ímpares")
    void somaParesMisto() {
        List<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        assertThat(calculoService.somaPares(lista)).isEqualTo(6);
    }

    @Test
    @DisplayName("Cenário 17 - Lista nula deve lançar exceção")
    void somaParesNula() {
        assertThrows(IllegalArgumentException.class, () -> calculoService.somaPares(null));
    }

    @Test
    @DisplayName("Cenário 18 - Apenas números pares negativos")
    void somaParesNegativos() {
        List<Integer> lista = new ArrayList<>();
        lista.add(-2);
        lista.add(-4);
        lista.add(-6);
        int resultado = calculoService.somaPares(lista);
        assertThat(resultado).isLessThan(0).isEqualTo(-12);
    }

}
