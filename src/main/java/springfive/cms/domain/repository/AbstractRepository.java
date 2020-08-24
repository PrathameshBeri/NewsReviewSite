package springfive.cms.domain.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractRepository<T> {


    private final List<T> elements = new ArrayList<>();

    public void delete(T element){

        Iterator<T> iterator = elements.listIterator();
        while(iterator.hasNext()){

            T ele = iterator.next();
            if(element.equals(ele)){
                elements.remove(ele);
                break;
            }
        }
    }

    public T save(T element){
        this.elements.add(element);
        return element;
    }

    public List<T> findAll(){

        return this.elements;
    }

    public void updateElement(T ele){


    }


    public T findOne(String id){

        return this.elements.stream().filter(ele -> ele.equals(id)).findFirst().get();
    }



}
