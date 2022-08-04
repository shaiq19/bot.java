package humanModel;

import java.time.Instant;

public class Model {

    private  int id;
    private String name;
    private String img;
    private String des;

        public Model(int id, String img,String name, String des) {
            this.id=id;
            this.name = name;
            this.img = img;
            this.des = des;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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
            return getId()+" "+getDes()+" "+getImg()+" "+getName();
        }
    }
