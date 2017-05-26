package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.entities.Car;
import model.entities.Client;
import model.entities.Client.Gender;
import services.CarService;
import services.ClientService;

/**
 * Servlet implementation class getClient
 */
public class getClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Client client = new Client();
		List<Car> clientCars = new ArrayList<Car>();
		if (!"new".equals(request.getParameter("id"))) {
			int client_id = Integer.valueOf(request.getParameter("id"));

			Objects.requireNonNull(client_id);
			client = ClientService.getClientById(client_id);

			clientCars = CarService.getAllCarsByOwner(client.getId_client());

		} else {

		}
		request.setAttribute("client", client);
		request.setAttribute("clientCars", clientCars);
		request.getRequestDispatcher("/WEB-INF/view/getClient.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int z = Integer.valueOf(request.getParameter("id"));
		Objects.requireNonNull(z);
		Client cl = new Client();
		String action = request.getParameter("act");
		if (action.equals("Delete")) {
			ClientService.deleteClientById(z);
		} else if (action.equals("Update")) {
			Gender gender = checkGender(request);
			if (gender == null) {
				doGet(request, response);
				return;
			}
			try {
				cl = Client.newBuilder().setId_client(z).setName(request.getParameter("name")).setGender(gender)
						.setCar_count(Integer.valueOf(request.getParameter("carCount")))
						.setService_count(Integer.valueOf(request.getParameter("serviceCount")))
						.setPhone_number(request.getParameter("phoneNumber")).build();
				ClientService.updateClient(cl);
			} catch (Exception e) {
				response.sendRedirect("./client?id=new");
				return;
			}
		} else if (action.equals("Insert")) {
			Gender gender = checkGender(request);
			if (gender == null) {
				response.sendRedirect("./client?id=new");
				return;
			}

			try {
				cl = Client.newBuilder().setName(request.getParameter("name")).setGender(gender)
						.setCar_count(Integer.valueOf(request.getParameter("carCount")))
						.setService_count(Integer.valueOf(request.getParameter("serviceCount")))
						.setPhone_number(request.getParameter("phoneNumber")).build();

				ClientService.createClient(cl);
			} catch (Exception e) {
				response.sendRedirect("./client?id=new");
				return;
			}
		}
		response.sendRedirect("./clients");
	}

	protected Gender checkGender(HttpServletRequest request) {
		if ("male".equals(request.getParameter("gender"))) {
			return Gender.male;
		} else if ("female".equals(request.getParameter("gender"))) {
			return Gender.female;
		} else
			return null;
	}
}
