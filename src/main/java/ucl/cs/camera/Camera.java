package ucl.cs.camera;

public class Camera implements WriteListener {

  private MemoryCard memoryCard;
  private Sensor sensor;
  private boolean powerOn = false;
  private boolean writing = false;

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
      this.writing=true;
    }
  }

  public void powerOn() {
    sensor.powerUp();
    this.powerOn=true;
  }

  public void powerOff() {
    if(this.writing==false)
      sensor.powerDown();
  }

  public boolean getPower()
  {
    return this.powerOn;
  }
  @Override
  public void writeComplete()
  {
    if(this.writing)
    {
      this.writing=false;
      sensor.powerDown();
    }
  }
}

