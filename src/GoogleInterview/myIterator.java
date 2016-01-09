package GoogleInterview;

import java.util.Iterator;

/**
 * Created by Jesus Zarate on 1/9/16.
 */
public class myIterator implements Iterator<Object>
{

        Iterator<Object> itr;
        public myIterator(Iterator<Object> _itr){
            this.itr = _itr;
        }

        @Override
        public boolean hasNext(){

            if(itr.hasNext())
                return true;
            else return false;
        }

        @Override
        public Integer next(){

            Object current = null;
            if(itr.hasNext())
                current = itr.next();

            while(current == null)
            {
                if(itr.hasNext()){
                    Object temp = itr.next();
                    if(temp == null){
                        current = itr.next();
                    }
                }
            }
            return next();
        }

    @Override
    public void remove()
    {

    }
}
