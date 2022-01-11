package travel.w2m.sh.maint.ws.exception;

import travel.w2m.sh.maint.ws.message.Messages;

public class SuperHeroException extends RuntimeException {

  private static final long serialVersionUID = -3149207615155492297L;

  private final String message;

  public SuperHeroException(Long id) {
    this.message = String.format("ID not found: %d", id);
  }

  public SuperHeroException(String message) {
    this.message = message;
  }

  public static SuperHeroException notFound() {
    return new SuperHeroException(Messages.ID_NOT_FOUND);
  }

  public String getMessage() {
    return message;
  }

}