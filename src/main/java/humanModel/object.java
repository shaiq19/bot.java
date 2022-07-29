package humanModel;

    public class object  {

        String name;
        String img;
        String des;

        public object(String name, String img, String des) {
            this.name = name;
            this.img = img;
            this.des = des;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
         public String toString(){//overriding the toString() method
            return getDes()+" "+getImg()+" "+getName();
        }
    }
