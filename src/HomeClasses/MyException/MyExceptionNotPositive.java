package HomeClasses.MyException;

public class MyExceptionNotPositive extends RuntimeException{
        /**
         * Constructs a {@code MyExceptionNotPositive} with no detail message.
         */
        public MyExceptionNotPositive() {
            super();
        }

        /**
         * Constructs a {@code MyExceptionNotPositive} with the specified
         * detail message.
         *
         * @param   s   the detail message.
         */
        public MyExceptionNotPositive(String s) {
            super(s);
        }
}
