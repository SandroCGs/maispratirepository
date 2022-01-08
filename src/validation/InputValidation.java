package validation;

import exception.RegraNegocioException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InputValidation {

    public static LocalDate validaData(String data) {
        if (!data.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new RegraNegocioException("Formato de data inv�lido!");
        }
        LocalDate localDate = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        if (localDate.isAfter(LocalDate.now())) {
            throw new RegraNegocioException("Esta data n�o est� vigente!");
        }
        return localDate;
    }

    public static void validaTelefone(String telefone) {
        if (!telefone.matches("\\(\\d{2}\\)\\d{8,9}")) {
            throw new RegraNegocioException("Formato de telefone inv�lido!");
        }
    }

    public static void validaNota(String nota) {
        if (!nota.isBlank() && !nota.matches("\\d*.?\\d+")) {
            throw new RegraNegocioException("Formato de nota inv�lida!");
        }
    }
}