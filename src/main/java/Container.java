public class Container<T> {
    /**
     * Массив объектов для хранения элементов
     */
    public Object[] container;
    /**
     * Переменная, хранящая размер массива
     */
    private int count;
    /**
     * Переменная, отвечающая за увеличение размера массива при переполнении
     */
    private static final int addNum=5;
    /**
     * Конструктор , инициализируюший масисв container
     */
    public Container()
    {
        container = new Object[addNum];
        count=0;
    }

    /**
     * Фцункция добавления элемента. При переполнении массива увеличиваем его размер на величину  addNum
     * @param elem - добавляемый элемент
     */
    public void add(T elem){
        if(count >= container.length){
            container = resizeContainer(addNum);
        }
        container[count] = elem;
        count++;
    }

    /**
     * Функция увеличения размера контейнера на величину addNum.
     * @param myNum - величина, на которую увеливается размер массива
     * @return контейнер с размером, увеличенным на величину addNum
     */
    private Object[] resizeContainer(int myNum){
        Object[] newContainer = new Object[container.length + myNum];
        for(int i=0;i<container.length;i++){

            newContainer[i]=container[i];
        }
        return  newContainer;
    }

    /**
     * Функция удаления элемента из контейнера
     * @param index - индекс удаляемого элемента
     * @return false, если такого индекса в массиве не существует
     */
    public boolean delete(int index)
    {
        if(index>=count||index<0)
            return false;
        for(int i=index;i< container.length-1;i++){

            container[i]=container[i+1];

        }
        container[container.length-1]=null;
        count--;
        return true;
    }

    /**
     * Функция получения эелемнта из контейнера  по индексу
     * @param index- индекс получаемого элемента
     * @return Если данного индекса не существует в контейнере, то возвращает null, иначе искомый элемент
     */
    public T get(int index){
        if(index>=count||index<0)
            return null;
        return (T) container[index];

    }

    /**
     * Функция добавления элемента на указанную позицию
     * @param elem - объект для добавления
     * @param index - позиция для добавления
     * @return false, если индекс отрицательный, иначе true
     */
    public boolean setOnIndex(T elem, int index){
        if(index < 0 ){
            return false;
        }
        else{
            container=resizeContainer((index-container.length +1));
            count=index;
            container[index] = elem;
            return true;
        }
    }

}
