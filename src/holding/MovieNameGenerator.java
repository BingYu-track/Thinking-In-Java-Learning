package holding;



public class MovieNameGenerator implements Generator<String> {

    int next;
    String[] characters = {"Grumpy", "Happy", "Sleepy", "Dopey", "Doc", "Sneezy",
             "Bashful", "Snow White", "Witch Queen", "Prince"};  //电影名
    public String next() {
        String r = characters[next];
        next = (next + 1) % characters.length;
        return r;
    }

    public static void main(String[] args){
        int i = 2;
        int j = 10;
        System.out.println(i % 10);
    }
}
