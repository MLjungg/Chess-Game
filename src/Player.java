class Player {
    String color;
    int[] reservedCoordinates;


    Player(String color) {
        this.color = color;
        this.reservedCoordinates = new int[2];
    }
    void reservCoordinates(int i, int j){
        this.reservedCoordinates[0] = i;
        this.reservedCoordinates[1] = j;
    }

}
