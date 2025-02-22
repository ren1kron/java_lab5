package org.ren1kron.module;

/**
 * Экземпляры этого интерфейса можно проверить на валидность
 */
public interface Validatable {
    /**
     * @return Валидность данных
     */
    boolean validate();
}
