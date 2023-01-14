import java.util.ArrayList;
import java.util.Comparator;

public class Heap {
    //Min-heap: as chaves dos filhos são maiores ou iguais às chaves dos pais

    ArrayList<Object> heapArray;
    Comparator<Object> comparaChaves = new Comparator<Object>() {
        @Override
        public int compare(Object chave1, Object chave2) {
            int intchave1 = (int) chave1;
            int intchave2 = (int) chave2;
            // se a primeira chave é menor que a segunda, o método retorna um número negativo,"-1"
            if (intchave1 < intchave2) {
                return -1;
            }
            // se a primeira chave é maior que a segunda, o método retorna um número positivo,"1"
            if (intchave1 > intchave2) {
                return 1;
            }
            // se a primeira chave é igual à segunda, o método retorna "0"
            else {
                return 0;
            }

        }
    };

    public Heap() {
        this.heapArray = new ArrayList<>();
    }

    public void addChave(Object chave, Object elemento) {
        heapArray.add(chave);
        heapArray.add(elemento);
        // encontra o nó de inserção
        int indexNovoNo = heapArray.size() - 2;
        // para restaurar a propriedade heap-order
        upHeap(indexNovoNo);
    }

    public void upHeap(int indexNovoNo) {
        // enquanto o nó de inserção não for a raiz e sua chave for menor que a chave de seu pai
        while (indexNovoNo > 0 && comparaChaves.compare(heapArray.get(indexNovoNo), heapArray.get((indexNovoNo - 1) / 2)) < 0) {
            // troca as posições dos elementos no ArrayList
            Object temp = heapArray.get(indexNovoNo);
            heapArray.set(indexNovoNo, heapArray.get((indexNovoNo - 1) / 2));
            heapArray.set((indexNovoNo - 1) / 2, temp);
            // atualiza o nó de inserção
            indexNovoNo = (indexNovoNo - 1) / 2;
        }

    }

    public Object removeMin() throws InvalidKeyException {
        // checando se a heap ta vazia
        if (heapArray.size() == 0) {
            throw new InvalidKeyException("Não é possível excluir essa chave pois a heap se encontra vazia");
        }
        return null;
    }

    public Object min() throws InvalidKeyException {
        // checando se a heap ta vazia
        if (heapArray.size() == 0) {
            throw new InvalidKeyException("Não é retornar essa chave pois a heap se encontra vazia");
        }
        return heapArray.get(0);
    }

    public boolean isEmpty() {
        return heapArray.size() == 0;
    }

    public int size() {
        return heapArray.size();
    }

    public void printHeap() {
        for (int i = 0; i < heapArray.size(); i += 2) {
            System.out.println("Chave: " + heapArray.get(i) + ", Elemento: " + heapArray.get(i + 1));
        }
    }
}


