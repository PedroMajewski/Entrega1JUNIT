package app.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dto.Entrada;
import app.entity.Calculo;
import app.repository.CalculoRepository;

@Service
public class CalculoService {

	@Autowired
	private CalculoRepository calculoRepository;

	public Calculo calcular(Entrada entrada) {
		
		List<Integer> lista = entrada.getLista();
	    Calculo calculo = new Calculo();
	    calculo.setLista(lista);
	    calculo.setSoma(this.soma(lista));
	    calculo.setMedia(this.media(lista));
	    calculo.setMediana(this.mediana(lista));
	    calculo.setModa(this.modaLista(lista));
	    calculo.setMaior(this.maiornumerolista(lista));
	    calculo.setMenor(this.menornumerolista(lista));
	    calculo.setTotal(lista.size());
	    calculo.setImpares(this.quantidadeImpares(lista));
	    calculo.setSomaPares(this.somaPares(lista));
	    return calculo;

	}


	public int soma(List<Integer> lista) {
		int soma = 0;
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i) == null)
				throw new RuntimeException("dslçfjakd");
			else
				soma += lista.get(i);
		}
		return soma;
	}


	public double media(List<Integer> lista) {
		return this.soma(lista) / lista.size();
	}
	
	public double maiornumerolista(List<Integer> lista) {
		if (lista == null || lista.isEmpty()) {
	        throw new IllegalArgumentException("A lista não pode ser nula ou vazia");
	    }
		
		Collections.sort(lista);
		return lista.get(lista.size() - 1);	
	}
	
	public double menornumerolista(List<Integer> lista) {
		if (lista == null || lista.isEmpty()) {
	        throw new IllegalArgumentException("A lista não pode ser nula ou vazia");
	    }
		
		Collections.sort(lista);
		//Retorna um valor igual à zero
		return lista.get(lista.size() - lista.size());	
	}
	
	public double numeroslista(List<Integer> lista) {
		if (lista == null || lista.isEmpty()) {
	        throw new IllegalArgumentException("A lista não pode ser nula ou vazia");
	    }
		
		Collections.sort(lista);
		//Retorna um valor igual à zero
		return lista.size();
	}

	public Integer modaLista(List<Integer> lista) {
	    if (lista == null || lista.isEmpty()) {
	        throw new IllegalArgumentException("A lista não pode ser nula ou vazia");
	    }

	    Map<Integer, Integer> frequencias = new HashMap<>();
	    for (int num : lista) {
	        frequencias.put(num, frequencias.getOrDefault(num, 0) + 1);
	    }

	    int moda = lista.get(0);
	    int maxFrequencia = 0;

	    for (Map.Entry<Integer, Integer> entry : frequencias.entrySet()) {
	        if (entry.getValue() > maxFrequencia) {
	            maxFrequencia = entry.getValue();
	            moda = entry.getKey();
	        }
	    }

	    return moda;
	}


	public double mediana(List<Integer> lista) {
		if (lista == null || lista.isEmpty()) {
	        throw new IllegalArgumentException("A lista não pode ser nula ou vazia");
	    }
		
		Collections.sort(lista);

	    if (lista.size() % 2 == 1) { //ÍMPAR
	        return lista.get(lista.size() / 2);
	    } else {
	        int meio1 = lista.get(lista.size() / 2 - 1);
	        int meio2 = lista.get(lista.size() / 2);
	        return (meio1 + meio2) / 2;
	    }
	}

	public int quantidadeImpares(List<Integer> lista) {
	    if (lista == null || lista.isEmpty()) {
	        throw new IllegalArgumentException("A lista não pode ser nula ou vazia");
	    }

	    int count = 0;
	    for (int num : lista) {
	        if (num % 2 != 0) {
	            count++;
	        }
	    }

	    return count;
	}

	public int somaPares(List<Integer> lista) {
	    if (lista == null || lista.isEmpty()) {
	        throw new IllegalArgumentException("A lista não pode ser nula ou vazia");
	    }

	    int soma = 0;
	    for (int num : lista) {
	        if (num % 2 == 0) {
	            soma += num;
	        }
	    }

	    return soma;
	}


}
