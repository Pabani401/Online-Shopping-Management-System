public class Clothing extends Product{
        private String size;
        private String colour;

        public Clothing(String Id, String name, int no_of_available_items, double price,String size, String colour){
                super( Id, name,  no_of_available_items, price);
                this.size=size;
                this.colour=colour;

        }

        public Clothing() {


        }

        public Clothing(String size, String colour) {
                this.size=size;
                this.colour=colour;
        }

        public Clothing(String size, String colour, String name, int noOfAvailableItems, double price) {
        }

        public Clothing(String Id, String size, String colour, String name, int noOfAvailableItems, double price) {
        }

        public String getColour(){
                return colour;
        }
        public void setColour(){
                this.colour=colour;
        }

        public String getSize(){
                return size;
        }
        public void setSize(){
                this.size=size;
        }

        @Override
        public String toString() {
                return "Clothing{" +
                        "size=" + size +
                        ", colour='" + colour + '\'' +
                        '}';
        }
}
