package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractArrayListData <T>{
    /**
     *
     *
     * @param <T>
     */
        protected List<T> elements;

        public AbstractArrayListData() {
            this.elements = new ArrayList<>();
        }

        public void create(T newObj) {
            if (!this.elements.contains(newObj)) {
                this.elements.add(newObj);
            }
        }

        public List<T> recover() {
            return Collections.unmodifiableList(this.elements);
        }

        public void update(T newElementWithID) {
            int index = this.elements.indexOf(newElementWithID);
            if (index >= 0) {
                this.elements.set(index, newElementWithID);
            }
        }

        public void delete(T newElementWithID) {
            int index = this.elements.indexOf(newElementWithID);
            if (index >= 0) {
                this.elements.remove(index);
            }
        }
}

