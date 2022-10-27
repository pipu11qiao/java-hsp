class Tree{
    int height;
    Tree(){
        System.out.println("Planting a seedling");
        height = 0;
    }
    Tree(int initialHeight){
        height = initialHeight;
        System.out.println("Creating new Tree that is " + height + " feet tall");
    }
}
