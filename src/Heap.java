import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class Heap {
    //Min-heap: as chaves dos filhos são maiores ou igual que a chave do pai

    ArrayList<Object> heapArray;
    Comparator<Object> comparaChaves;


    public Heap(Comparator<Object> comparaChaves){
        this.heapArray = new ArrayList<>();
        this.comparaChaves = comparaChaves;
        // se a primeira chave é menor que a segunda, o método retorna um número negativo,"-1"
        // se a primeira chave é igual à segunda, o método retorna "0"
        // se a primeira chave é maior que a segunda, o método retorna um número positivo,"1"
    }

    public void addChave(Object chave, Object elemento){
        // adiciona a chave em um par
        heapArray.add(chave);
        // adiciona o elemento em um impar
        heapArray.add(elemento);
        int indexChave = heapArray.size() - 2;
        int indexPai = (indexChave - 2) / 2;
        // 'loop' para checar a ordem das chaves
        while (indexChave > 0 && comparaChaves.compare(heapArray.get(indexChave),heapArray.get(indexPai)) < 0){
            // enquanto o index da chave for maior que zero e a comparação entre index chave e index pai for
            // menor que zero, ou seja, o index da chave é menor que o do pai
            Object temp = heapArray.get(indexChave);
            // guarda o index da chave
            heapArray.set(indexChave,heapArray.get(indexPai));
            // usa o 'set' para trocar o index do filho para o pai
            heapArray.set(indexPai,temp);
            // usa o 'set' para trocar o index do pai para o filho guardado no temp

            indexChave = indexPai;
            indexPai = (indexChave - 2) / 2;
            // atualiza o index da chave e do pai
        }
    }

    public Object removeMin() throws InvalidKeyException {
        // checando se a heap ta vazia
        if(heapArray.size() == 0){
            throw new InvalidKeyException("Não é possível excluir essa chave pois a heap se encontra vazia");
        }
        // sempre vai ser removido a raiz porque ela é a menor
        Object chaveRemovida = heapArray.get(0);

        // substitui o elemento raiz pelo último elemento
        heapArray.set(0, heapArray.get(heapArray.size() - 2));

        // substitui a última chave pelo último elemento
        heapArray.set(heapArray.size() - 2, heapArray.get(heapArray.size() - 1));

        // remove o último elemento
        heapArray.remove(heapArray.size() - 1);
        // remove a última chave
        heapArray.remove(heapArray.size() - 1);

        // agora ajeitar a prioridade das chaves

        int index = 0;
        // enquanto o index for menor que o tamano do array
        // (não é realmente necessario porque se o array for iniciado ele nunca vai ser zero mas so por via das duvidas)
        while (index < heapArray.size()){
            // contas loucas
            int filhoEsquerdo = index*2 + 1;
            int filhoDireito = index*2 + 2;
            int oMenor = index;

           // comparações para veridicar quem é a menor chave
            if(filhoEsquerdo < heapArray.size() &&
                    comparaChaves.compare(heapArray.get(filhoEsquerdo), heapArray.get(oMenor)) < 0){
                oMenor = filhoEsquerdo;
            }
            if(filhoDireito < heapArray.size() &&
                    comparaChaves.compare(heapArray.get(filhoDireito), heapArray.get(oMenor)) < 0){
                oMenor = filhoDireito;
            }
            if(oMenor == index){
                break;
            }

            // guardando o index do em uma variável temporária
            Object temp = heapArray.get(index);
            // setando a menor chave como index
            heapArray.set(index, heapArray.get(oMenor));
            // setando o menor com o que estava guardado na variável temporária
            heapArray.set(oMenor,temp);
            index = oMenor;

        }

       return chaveRemovida;
    }

    public Object min()throws InvalidKeyException {
        // checando se a heap ta vazia
        if(heapArray.size() == 0){
            throw new InvalidKeyException("Não é retornar essa chave pois a heap se encontra vazia");
        }
        return heapArray.get(0);
    }

    public boolean isEmpty(){
        return heapArray.size() == 0;
    }

    public int size(){
        return heapArray.size();
    }
}
