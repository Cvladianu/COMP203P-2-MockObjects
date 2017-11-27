package ucl.cs.camera;

public class Camera implements WriteListener {

  private MemoryCard memoryCard;
  private Sensor sensor;

  public Camera(MemoryCard memoryCard, Sensor sensor)
  {
    this.memoryCard=memoryCard;
    this.sensor=sensor;
  }

  public void pressShutter() {
    // not implemented
  }

  public void powerOn() {
    sensor.powerUp();
  }

  public void powerOff() {
    // not implemented
  }

  @Override
  public void writeComplete()
  {

  }
}

