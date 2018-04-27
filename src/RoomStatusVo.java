public class RoomStatusVo implements Comparable<RoomStatusVo>{

    private Integer batteryEnergy;

    public RoomStatusVo(Integer batteryEnergy) {
        this.batteryEnergy = batteryEnergy;
    }

    public RoomStatusVo() {
    }

    public Integer getBatteryEnergy() {
        return batteryEnergy;
    }

    public void setBatteryEnergy(Integer batteryEnergy) {
        this.batteryEnergy = batteryEnergy;
    }

    @Override
    public int compareTo(RoomStatusVo o) {
        int i = this.batteryEnergy-o.batteryEnergy;
        return -i;
    }

    @Override
    public String toString() {
        return "RoomStatusVo{" +
                "batteryEnergy=" + batteryEnergy +
                '}';
    }
}
