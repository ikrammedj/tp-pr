package exo1;
class Resource {
    private StringBuilder str = new StringBuilder();

    
    public synchronized void addChar(int i) {
        char c = (char) ('A' + (i % 26)); 
        str.append(c);
    }

   
    public synchronized void addInt(int i) {
        str.append(i);
    }

    
    public String getStr() {
        return str.toString();
    }

    
    public int getLength() {
        return str.length();
    }
}