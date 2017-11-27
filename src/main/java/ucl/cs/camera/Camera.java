package ucl.cs.camera;

public class Camera implements WriteListener {

  private MemoryCard memoryCard;
  private Sensor sensor;
  private boolean powerOn = false;

  public Camera(MemoryCard memoryCard, Sensor sensor)
  {
    this.memoryCard=memoryCard;
    this.sensor=sensor;
  }

  public void pressShutter() {
    if(this.powerOn==true)
    {
      byte[] IMG = sensor.readData();
      memoryCard.write(IMG);
    }
  }

  public void powerOn() {
    sensor.powerUp();
    this.powerOn=true;
  }

  public void powerOff() {
    sensor.powerDown();
  }

  public boolean getPower()
  {
    return this.powerOn;
  }
  @Override
  public void writeComplete()
  {

  }
}

